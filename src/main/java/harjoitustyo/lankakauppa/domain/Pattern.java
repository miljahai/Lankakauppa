package harjoitustyo.lankakauppa.domain;


import javax.persistence.Entity;
import javax.validation.constraints.Size;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Pattern {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long patternid;
	@Size(min = 1, max = 50)
	private String name;
	@Size(min = 1, max = 1000)
	private String content;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="yarnid")
	private Yarn yarn;

	public Pattern() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pattern(Long patternid, String name, String content, Yarn yarn) {
		super();
		this.patternid = patternid;
		this.name = name;
		this.content = content;
		this.yarn = yarn;
	}
	
	public Pattern(String name, String content, Yarn yarn) {
		super();
		this.name = name;
		this.content = content;
		this.yarn = yarn;
	}

	public Long getPatternid() {
		return patternid;
	}

	public void setPatternid(Long patternid) {
		this.patternid = patternid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Yarn getYarn() {
		return yarn;
	}

	public void setYarn(Yarn yarn) {
		this.yarn = yarn;
	}

	@Override
	public String toString() {
		return "Pattern [patternid=" + patternid + ", name=" + name + ", content=" + content + ", yarn=" + yarn + "]";
	}
	
	
	
	

}
