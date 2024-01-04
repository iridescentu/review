package project.lms.enumstatus;

public enum BenefitType {
	COURSE_COMPLETION("완강"),
	EXAM_COMPLETION("수료");
	
	private final String desc;
	
	private BenefitType(String desc) {
		this.desc = desc;
	}
	
	public String getDesc() {
		return desc;
	}
}