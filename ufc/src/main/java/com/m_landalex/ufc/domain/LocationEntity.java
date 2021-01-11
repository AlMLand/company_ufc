package com.m_landalex.ufc.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.m_landalex.ufc.data.Country;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "location")
public class LocationEntity extends AbstractEntity {

	@Setter
	@Enumerated(EnumType.STRING)
	private Country country;
	@Setter
	private String hallName;
	@Setter
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", referencedColumnName = "id")
	private AddressEntity address;
	
	@OneToMany(mappedBy = "eventLocation")
	private List<EventEntity> eventEntities;

	public void setEventEntities(List<EventEntity> eventEntities) {
		eventEntities.forEach(evetnEntity -> evetnEntity.setEventLocation(this));
		this.eventEntities = eventEntities;
	}
	
	public void addEventEntity(EventEntity eventEntity) {
		this.eventEntities.add(eventEntity);
		eventEntity.setEventLocation(this);
	}
	
}
