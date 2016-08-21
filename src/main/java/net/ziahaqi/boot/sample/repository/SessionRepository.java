package net.ziahaqi.boot.sample.repository;

import net.ziahaqi.boot.sample.entity.Material;
import net.ziahaqi.boot.sample.entity.Session;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by ziahaqi on 8/14/16.
 */
public interface SessionRepository extends PagingAndSortingRepository<Session, String> {

    Page<Session> findByMaterial(Material material, Pageable pageable);

    List<Session> findBydateStart(Date dateStart);

    List<Session> findByDateFinish(Date dateFinish);

}
