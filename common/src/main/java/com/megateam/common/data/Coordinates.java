package com.megateam.common.data;

import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This data class contains coordinates information
 * Is used in Ticket data class
 */
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Getter
@EqualsAndHashCode
@XmlRootElement(name = "coordinates")
@XmlAccessorType(XmlAccessType.FIELD)
public class Coordinates
{
	/**
	 * This field contains X coordinate
	 */
	@NonNull
	@XmlElement(name = "xCoord", required = true)
	private float x;

	/**
	 * This field contains Y coordinate
	 */
	@NonNull
	@XmlElement(name = "yCoord", required = true)
	private Integer y;

	/**
	 * This method provides access to a string representation of coordinates class object
	 *
	 * @return coordinates string representation
	 */
	@Override
	public String toString()
	{
		return String.format("Coordinates: [x: %f, y: %d", x, y);
	}
}
