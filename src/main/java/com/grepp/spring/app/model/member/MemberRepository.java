package com.grepp.spring.app.model.member;

<<<<<<< HEAD
import org.apache.ibatis.annotations.Mapper;
=======
import com.grepp.spring.app.model.member.dto.Member;
import com.grepp.spring.app.model.member.dto.MemberInfo;
import java.util.Optional;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
>>>>>>> origin/kdy
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MemberRepository {

<<<<<<< HEAD
=======
    Optional<Member> selectById(String userid);

    @Select("select count(*) from member where user_id = #{userId}")
    Boolean existsMember(String userId);

    @Insert("insert into member (USER_ID, PASSWORD, USER_NAME, TEL, ROLE) "
        + "values(#{userId}, #{password}, #{username}, #{tel}, #{role})")
    void insert(Member dto);

    @Insert("insert into member_info(USER_ID) values (#{userId})")
    void insertInfo(MemberInfo memberInfo);
>>>>>>> origin/kdy
}
