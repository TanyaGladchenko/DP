
import java.text.ParseException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.impl.PlayerStatisticJdbc;
import entity.PlayerStatistic;

public class MainApp {

	private static ApplicationContext context;

	public static void main(String[] args) throws ParseException {
		context = new ClassPathXmlApplicationContext("application-context.xml");

		PlayerStatisticJdbc playerStatistic = (PlayerStatisticJdbc) context.getBean("playerStatisticJdbc");
		PlayerStatistic ps1 = new PlayerStatistic(0L, 5L, 1, 1, 1);
		PlayerStatistic ps2 = new PlayerStatistic(0L, 7L, 1, 1, 1);

//		playerStatistic.add(ps1);
//		playerStatistic.add(ps2);

		PlayerStatistic ps = playerStatistic.load(5L);
		System.out.println("1: " + ps);
		
		System.out.println("All");
		List<PlayerStatistic> list = playerStatistic.loadAll();
		for (PlayerStatistic p : list) {
			System.out.println(p);
		}
		ps1.setGamesLoose(10);
		ps1.setId(5L);
		playerStatistic.update(ps1);

		System.out.println("All");
		list = playerStatistic.loadAll();
		for (PlayerStatistic p : list) {
			System.out.println(p);
		}

		playerStatistic.delete(7L);
		System.out.println("Player");
		PlayerStatistic p = playerStatistic.loadByPlayer(5L);
		System.out.println(p);

	}

}
