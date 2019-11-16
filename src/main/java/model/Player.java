package model;

public class Player {

	static final int MAX_NAME_LENGTH = 5;
	private String name;

	public Player(String name) {
		validName(name);
		this.name = name;
	}

	private void validName(String name) {
		if (name.length() > MAX_NAME_LENGTH) {
			throw new IllegalArgumentException("이름은 다섯글자 이하로 입력해주세요.");
		}
	}

	public String getName() {
		return name;
	}

}
