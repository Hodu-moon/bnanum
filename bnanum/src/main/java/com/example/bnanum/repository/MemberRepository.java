package com.example.bnanum.repository;

import com.example.bnanum.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberRepository extends JpaRepository<Member, Long> {
//    // : id 파라미터 바인딩
//    // 순서 member_id => @Param("id") -> : id
//    @Query("SELECT m FROM Member m where m.id =:id")
//    public Member findByMemberId(@Param("id") String member_id);
//

    // select m from Member m where m.member_id = member_id 쿼리 생성
    Member findByMemberId(@Param("member_id")String member_id);
}
