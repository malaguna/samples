/**
 * This file is part of beforeShowDay.
 *
 * beforeShowDay is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * beforeShowDay is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with beforeShowDay.  If not, see <http://www.gnu.org/licenses/>.
 */
package beans;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class CalendarBean {
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private Date currentDay = new Date();

	public Date getCurrentDay() {
		return currentDay;
	}

	public void setCurrentDay(Date currentDay) {
		this.currentDay = currentDay;
	}

	/**
	 * This method return an array of dates. Every date must formatted as
	 * 'YYYY-MM-DD' including single quotes, in order to be parsed by
	 * javascript.
	 * 
	 * The array has three dates, yesterday, today and tomorrow
	 * 
	 * @return Array of string dates
	 */
	public String[] getSpecialDays() {
		String[] result = new String[3];

		Calendar cal = Calendar.getInstance();

		// yesterday
		cal.add(Calendar.DATE, -1);
		result[0] = String.format("'%s'", sdf.format(cal.getTime()));

		// Today
		cal.add(Calendar.DATE, 1);
		result[1] = String.format("'%s'", sdf.format(cal.getTime()));

		// Tomorrow
		cal.add(Calendar.DATE, 1);
		result[2] = String.format("'%s'", sdf.format(cal.getTime()));

		return result;
	}
}
