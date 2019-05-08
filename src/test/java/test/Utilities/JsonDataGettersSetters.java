package test.Utilities;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonDataGettersSetters {
	@JsonProperty("TabName") private List<String> tabName;
	@JsonProperty("FileName") private List<String> fileName;
	@JsonProperty("TaskName") private List<String> taskName;
	@JsonProperty("Department") private List<String> department;
	@JsonProperty("SubTaskDescription") private List<String> subtaskDescription;
	@JsonProperty("StartTask") private List<String> startTask;
	@JsonProperty("TaskDuration") private List<String> taskDuration;
	@JsonProperty("SubTaskStatus") private List<String> subtaskStatus;
	@JsonProperty("ClientApproval") private List<String> clientApproval;
	@JsonProperty("OutputRequirements") private List<String> outputRequirements;
	@JsonProperty("TaskDependencies") private List<String> taskDependencies;
	@JsonProperty("TabsSetup") private List<String> tabsSetup;
	@JsonProperty("Category") private List<String> category;

	@JsonProperty("Monday")	private Map <String, String> monday;
	@JsonProperty("Tuesday")private Map <String, String> tuesday;
	@JsonProperty("Wednesday")private Map <String, String> wednesday;
	@JsonProperty("Thursday")private Map <String, String> thursday;
	@JsonProperty("Friday")private Map <String, String> friday;
	@JsonProperty("Saturday")private Map <String, String> saturday;
	@JsonProperty("Sunday")private Map <String, String> sunday;

	public List<String> getTabName() {
		return tabName;
	}
	public void setTabName(List<String> tabName) {
		this.tabName = tabName;
	}
	public List<String> getFileName() {
		return fileName;
	}
	public void setFileName(List<String> fileName) {
		this.fileName = fileName;
	}
	
	public List<String> getTaskName() {
		return taskName;
	}
	public void setTaskName(List<String> taskName) {
		this.taskName = taskName;
	}
	public List<String> getDepartment() {
		return department;
	}
	public void setDepartment(List<String> department) {
		this.department = department;
	}
	public List<String> getSubtaskDescription() {
		return subtaskDescription;
	}
	public void setSubtaskDescription(List<String> subtaskDescription) {
		this.subtaskDescription = subtaskDescription;
	}
	public List<String> getStartTask() {
		return startTask;
	}
	public void setStartTask(List<String> startTask) {
		this.startTask = startTask;
	}
	public List<String> getTaskDuration() {
		return taskDuration;
	}
	public void setTaskDuration(List<String> taskDuration) {
		this.taskDuration = taskDuration;
	}
	public List<String> getSubtaskStatus() {
		return subtaskStatus;
	}
	public void setSubtaskStatus(List<String> subtaskStatus) {
		this.subtaskStatus = subtaskStatus;
	}
	public List<String> getClientApproval() {
		return clientApproval;
	}
	public void setClientApproval(List<String> clientApproval) {
		this.clientApproval = clientApproval;
	}
	public List<String> getOutputRequirements() {
		return outputRequirements;
	}
	public void setOutputRequirements(List<String> outputRequirements) {
		this.outputRequirements = outputRequirements;
	}
	public List<String> getTaskDependencies() {
		return taskDependencies;
	}
	public void setTaskDependencies(List<String> taskDependencies) {
		this.taskDependencies = taskDependencies;
	}
	public List<String> getTabsSetup() {
		return tabsSetup;
	}
	public void setTabsSetup(List<String> tabsSetup) {
		this.tabsSetup = tabsSetup;
	}

	public List<String> getCategory() {
		return category;
	}
	public void setCategory(List<String> category) {
		this.category = category;
	}
	
	public Map<String, String> getMonday() {
		return monday;
	}
	public void setMonday(Map<String, String> monday) {
		this.monday = monday;
	}
	public Map<String, String> getTuesday() {
		return tuesday;
	}
	public void setTuesday(Map<String, String> tuesday) {
		this.tuesday = tuesday;
	}
	public Map<String, String> getWednesday() {
		return wednesday;
	}
	public void setWednesday(Map<String, String> wednesday) {
		this.wednesday = wednesday;
	}
	public Map<String, String> getThursday() {
		return thursday;
	}
	public void setThursday(Map<String, String> thursday) {
		this.thursday = thursday;
	}
	public Map<String, String> getFriday() {
		return friday;
	}
	public void setFriday(Map<String, String> friday) {
		this.friday = friday;
	}
	public Map<String, String> getSaturday() {
		return saturday;
	}
	public void setSaturday(Map<String, String> saturday) {
		this.saturday = saturday;
	}
	public Map<String, String> getSunday() {
		return sunday;
	}
	public void setSunday(Map<String, String> sunday) {
		this.sunday = sunday;
	}
	
}
