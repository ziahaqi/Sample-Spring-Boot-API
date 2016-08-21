package net.ziahaqi.boot.sample.repository;

import net.ziahaqi.boot.sample.entity.Member;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by ziahaqi on 8/14/16.
 */
public interface MemberRepository extends PagingAndSortingRepository<Member, String> {

}
