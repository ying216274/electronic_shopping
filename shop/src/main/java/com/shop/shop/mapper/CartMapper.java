package com.shop.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shop.shop.entity.Cart;
import com.shop.shop.entity.CartVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CartMapper extends BaseMapper<Cart> {

	//根据用户id查询购物车
	@Select("SELECT\n" +
			"\tbsc.*, bsb.NAME AS bookName, bsb.img_url AS img_url,\n" +
			"\tbsb.new_price AS new_price\n" +
			"FROM\n" +
			"\tbs_cart bsc\n" +
			"LEFT JOIN bs_book bsb ON bsc.book_id = bsb.id\n" +
			"WHERE\n" +
			"\tbsc.user_id = #{userId}")
	List<CartVo> findCartListByUserId(int userId);

	//根据购物车ids查询购物车记录
	@Select({
			"<script>" +
				"SELECT\n" +
				"\tbsc.*, bsb.NAME AS bookName, bsb.img_url AS img_url,\n" +
				"\tbsb.new_price AS new_price\n" +
				"FROM\n" +
				"\tbs_cart bsc\n" +
				"LEFT JOIN bs_book bsb ON bsc.book_id = bsb.id\n" +
				"WHERE bsc.id in\n" +
				"<foreach item = 'item' collection = 'ids' open = '(' separator = ',' close = ')'>"+
				"#{item}" +
				"</foreach>" +
			"</script>"})
	List<CartVo> findCartListByIds(@Param("ids") List<String> ids);
}
