package dto;

public class Dept {
	private int deptNo;
	private String dName;
	private String loc;
	
	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public String getdName() {
		return dName;
	}

	public void setdName(String dName) {
		this.dName = dName;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	// dto만들 때 toString 꼭 해주기!
	@Override
	public String toString() {
		return "Dept [deptNo=" + deptNo
				+ ", dName=" + dName
				+ ", loc=" + loc + "]";
	}
}
