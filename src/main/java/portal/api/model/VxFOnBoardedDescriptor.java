package portal.api.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * @author ctranoris
 * maintains information and status of a VNF on which MANO providers is on-boarded
 * see https://github.com/5GinFIRE/eu.5ginfire.portal.api/issues/10 
 */
@Entity(name = "VxFOnBoardedDescriptor")
public class VxFOnBoardedDescriptor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id = 0;
	
	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH }, fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn() })
	private MANOprovider obMANOprovider;
	

	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH }, fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn() })
	private VxFMetadata vxf;
	
	private  OnBoardingStatus onBoardingStatus = OnBoardingStatus.UNKNOWN;
	
	private Date lastOnboarding;
	
	private String deployId = UUID.randomUUID().toString()+"(temporary)";

	public VxFOnBoardedDescriptor(VxFMetadata v) {
		this.vxf = v;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public MANOprovider getObMANOprovider() {
		return obMANOprovider;
	}

	public void setObMANOprovider(MANOprovider obMANOprovider) {
		this.obMANOprovider = obMANOprovider;
	}

	public VxFMetadata getVxf() {
		return vxf;
	}

	public void setVxf(VxFMetadata vxf) {
		this.vxf = vxf;
	}

	public OnBoardingStatus getOnBoardingStatus() {
		return onBoardingStatus;
	}

	public void setOnBoardingStatus(OnBoardingStatus onBoardingStatus) {
		this.onBoardingStatus = onBoardingStatus;
	}

	public Date getLastOnboarding() {
		return lastOnboarding;
	}

	public void setLastOnboarding(Date lastOnboarding) {
		this.lastOnboarding = lastOnboarding;
	}

	public String getDeployId() {
		return deployId;
	}

	public void setDeployId(String deployId) {
		this.deployId = deployId;
	}
	
	
}
