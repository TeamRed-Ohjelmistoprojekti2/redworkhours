package TeamRed.TimeManagementBE.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import TeamRed.TimeManagementBE.domain.Project.DetailedProjectView;
import TeamRed.TimeManagementBE.domain.Project.EntryListView;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@JsonView(EntryListView.class)
public class Entry {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Size(max = 250)
	private String comment;
	@NotNull
	private LocalDate entry_date;
	@NotNull
	private LocalTime start_time;
	@NotNull
	private LocalTime end_time;

	@ManyToOne
	@JoinColumn(name = "project_id")
	@JsonIgnoreProperties(value = {"roles", "entries"}, allowSetters = true)
	private Project project;

	@ManyToOne
	@JoinColumn(name = "app_user_id")
	@JsonIgnoreProperties(value = {"roles", "entries"}, allowSetters = true)
	@JsonView(DetailedProjectView.class)
	private AppUser appUser;

	public Entry() {
		super();
	}

	public Entry(String comment, LocalDate entry_date, LocalTime start_time, LocalTime end_time,
			Project project, AppUser appUser) {
		super();
		this.comment = comment;
		this.entry_date = entry_date;
		this.start_time = start_time;
		this.end_time = end_time;
		this.project = project;
		this.appUser = appUser;	
				}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public LocalDate getEntry_date() {
		return entry_date;
	}

	public void setEntry_date(LocalDate entry_date) {
		this.entry_date = entry_date;
	}

	public LocalTime getStart_time() {
		return start_time;
	}

	public void setStart_time(LocalTime start_time) {
		this.start_time = start_time;
	}

	public LocalTime getEnd_time() {
		return end_time;
	}

	public void setEnd_time(LocalTime end_time) {
		this.end_time = end_time;
	}

	
	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public AppUser getAppUser() {
		return appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

}
