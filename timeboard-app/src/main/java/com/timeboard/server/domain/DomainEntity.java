package com.timeboard.server.domain;

import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.ReadOnlyProperty;

import java.time.ZonedDateTime;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Version;

/**
 * Domain class entity. All domain objects should extends this class.
 *
 * @author Artem Motozov
 * @since 2021.04.17
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class DomainEntity {

	public static class ColumnName {

		public static final String DE_CN_CREATION_TIME = "creation_time";

		public static final String DE_CN_LAST_MODIFIED_TIME = "last_modified_time";

		public static final String DE_CN_TS = "ts";
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@Type(type = "uuid-char")
	@GeneratedValue
	private UUID id;

	@ReadOnlyProperty
	@CreatedDate
	@Column(name = ColumnName.DE_CN_CREATION_TIME, nullable = false)
	private ZonedDateTime creationDate;

	@LastModifiedDate
	@Column(name = ColumnName.DE_CN_LAST_MODIFIED_TIME)
	private ZonedDateTime lastModifiedDate;

	@Version
	@Column(name = ColumnName.DE_CN_TS, nullable = false)
	private Long ts;

	public ZonedDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(ZonedDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public ZonedDateTime getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(ZonedDateTime lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public Long getTs() {
		return ts;
	}

	public void setTs(Long ts) {
		this.ts = ts;
	}
}
