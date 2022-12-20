package tw.hibernatedemo.action;

import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernatedemo.model.Friends;
import tw.hibernatedemo.model.MyGroup;
import tw.hibernatedemo.util.HibernateUtil;

public class DemoManyToManyFriendActions {

	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			//只知道group id 3
			MyGroup group = session.get(MyGroup.class, 3);
			Set<Friends> friendsInWorkGroup = group.getFriends();
			Iterator<Friends> it = friendsInWorkGroup.iterator();
			
			while (it.hasNext()) {
				Friends friends = (Friends) it.next();
				System.out.println(friends.toString());
				
				if (friends.getName().equals("Tina")) {
					it.remove();
				}
				
			}
			
			Friends friends1 = new Friends();
			friends1.setName("Bill");
			session.save(friends1);
			
			friendsInWorkGroup.add(friends1);
			
			
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}finally {
			HibernateUtil.closeSessionFactory();
		}
	}

}
