package com.megateam.server.database.data;

import com.megateam.common.data.Ticket;
import com.megateam.common.data.util.LocalDateTimeAdapter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Container class for saving ticket database
 */
@XmlAccessorType(XmlAccessType.FIELD)
@RequiredArgsConstructor
@Getter
@XmlRootElement(name = "database")
public class TicketDatabaseDataclass
{
	/**
	 * Collection creation date
	 */
	@XmlElement(name = "dbCreationDate", required = true)
	@XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
	private final LocalDateTime creationDate;

	/**
	 * Collection data
	 */
	@XmlElementWrapper(name = "elements", required = true)
	@XmlElement(name = "element")
	private final List<Ticket> data;
}
