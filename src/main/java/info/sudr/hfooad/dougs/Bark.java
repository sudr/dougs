package info.sudr.hfooad.dougs;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Bark {

	private final String sound;

	public Bark(String sound) {
		this.sound = sound;
	}

	public String getSound() {
		return sound;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(sound).toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		Bark other = (Bark) obj;
		return new EqualsBuilder().append(sound, other.sound).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(11).append(this.sound).toHashCode();
	}

}
