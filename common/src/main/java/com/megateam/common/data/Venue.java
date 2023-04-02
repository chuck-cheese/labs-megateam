package com.megateam.common.data;

import com.megateam.common.data.util.VenueType;
import lombok.*;

import javax.xml.bind.annotation.*;

/**
 * This data class contains venue information
 * Is used in Ticket data class
 */
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@EqualsAndHashCode
@XmlRootElement(name = "venue")
@XmlAccessorType(XmlAccessType.FIELD)
public class Venue
{
	/**
	 * This field contains unique venue id
	 */
	@NonNull
	@XmlAttribute(name = "venueId", required = true)
	private long id;

	/**
	 * This field contains venue name
	 */
	@NonNull
	@XmlElement(name = "venueName", required = true)
	private String name;

	/**
	 * This field contains venue capacity
	 */
	@NonNull
	@XmlElement(name = "capacity", required = true)
	private Integer capacity;

	/**
	 * This field contains venue type (can be null)
	 */
	@XmlElement(name = "venueType")
	private VenueType type;

	/**
	 * This method provides access to a string representation of venue class object
	 *
	 * @return venue string representation
	 */
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("VenueID: ").append(id).append('\n');
		sb.append("Venue name: ").append(name).append('\n');
		sb.append("Venue capacity: ").append(capacity).append('\n');
		sb.append("Venue type: ").append((type == null) ? "not currently set" : type).append('\n');

		return sb.toString();
	}
}
