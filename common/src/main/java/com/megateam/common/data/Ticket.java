package com.megateam.common.data;

import com.megateam.common.data.util.LocalDateTimeAdapter;
import com.megateam.common.data.util.TicketType;
import lombok.*;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDateTime;

/**
 * This data class contains ticket information
 * Is stored in the database
 */
@AllArgsConstructor
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Getter
@EqualsAndHashCode
@XmlRootElement(name = "ticket")
@XmlAccessorType(XmlAccessType.FIELD)
public class Ticket implements Comparable<Ticket>
{
	/**
	 * This field contains unique ticket id
	 */
	@Setter
	@XmlAttribute(name = "ticketId", required = true)
	private Integer id;

	/**
	 * This fields contains ticket name
	 */
	@NonNull
	@XmlAttribute(name = "ticketName", required = true)
	private String name;

	/**
	 * This field contains ticket coordinates
	 */
	@NonNull
	@XmlElement(name = "ticketCoordinates", required = true)
	private Coordinates coordinates;

	/**
	 * This field contains ticket creation date
	 */
	@NonNull
	@XmlElement(name = "ticketCreationDate", required = true)
	@XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
	private LocalDateTime creationDate;

	/**
	 * This field contains ticket price
	 */
	@NonNull
	@XmlElement(name = "ticketPrice", required = true)
	private float price;

	/**
	 * This field contains ticket comment
	 */
	@NonNull
	@XmlElement(name = "ticketComment", required = true)
	private String comment;

	/**
	 * This field contains ticket refundable status
	 */
	@NonNull
	@XmlElement(name = "refundable", required = true)
	private Boolean refundable;

	/**
	 * This field contains ticket type (can be null)
	 */
	@XmlElement(name = "ticketType")
	private final TicketType type;

	/**
	 * This field contains ticket venue
	 */
	@NonNull
	@XmlElement(name = "ticketVenue", required = true)
	private Venue venue;

	/**
	 * This method returns a comparison result for this object and the specified one
	 *
	 * @param obj the object to be compared
	 * @return comparison result (default comparison strategy with: less, equals and greater than zero)
	 */
	@Override
	public int compareTo(Ticket obj)
	{
		if (this.equals(obj)) return 0;
		return this.name.compareTo(obj.name);
	}

	/**
	 * This method provides access to a string representation of ticket class object
	 *
	 * @return ticket string representation
	 */
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Ticket id: ").append(id).append('\n');
		sb.append("Ticket name: ").append(name).append('\n');
		sb.append("Ticket coordinates: ").append('\t').append(coordinates).append('\n');
		sb.append("Ticket creation date: ").append(creationDate).append('\n');
		sb.append("Ticket price: ").append(price).append('\n');
		sb.append("Ticket comment: ").append(comment).append('\n');
		sb.append("Ticket refundable status: ").append(refundable).append('\n');
		sb.append("Ticket type: ").append((type == null) ? "not currently set" : type).append('\n');
		sb.append("Ticket venue: ").append('\t').append(venue).append('\n');

		return sb.toString();
	}
}
