package ch.fhnw.thrift.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.fhnw.thrift.data.domain.SuspiciousItemReport;

public interface SuspiciousItemReportRepository extends JpaRepository<SuspiciousItemReport, Long> {
    List<SuspiciousItemReport> findByItemId(Long itemId);
}
