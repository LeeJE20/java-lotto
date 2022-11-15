package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.ui.ManagerMessage;

public class Manager {
	private static final String SPLIT = ",";
	private List<Lotto> lottos;
	private List<Integer> win;

	private Lotto makeLotto() {
		List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
		return new Lotto(sort(numbers));
	}

	private List<Integer> sort(List<Integer> numbers) {
		List<Integer> sorted = new ArrayList<Integer>(numbers);
		sorted.sort(Comparator.naturalOrder());
		return sorted;
	}

	public void setLottos(int count) {
		lottos.clear();
		for (int i = 0; i < count; i++) {
			lottos.add(makeLotto());
		}
	}

	public void printLottos() {
		for (Lotto lotto : lottos) {
			System.out.println(lotto.getNumbers().toString());
		}
	}

	public void setWin() {
		System.out.println(ManagerMessage.INSERT_WIN_NUMBERS.getMessage());
		String input = readLine();
		win = separateWinInput(input);
	}

	private List<Integer> separateWinInput(String input) {
		List<Integer> result = new ArrayList<Integer>();
		List<String> splited = Arrays.asList(input.split(SPLIT));
		if (splited.size() != 6) {
			throw new IllegalArgumentException();
		}
		for(String s:splited) {
			if (!Util.isInteger(s)) {
				throw new IllegalArgumentException();
			}
			result.add(Integer.parseInt(s));
		}
		return result;
	}
}
