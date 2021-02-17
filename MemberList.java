package MEM;

import java.util.*;

public class MemberList extends ArrayList<Member>{	
	
	ArrayList<Member> members;
	
	public MemberList(){
		members = new ArrayList<Member>();
		//AddOriginalMembers(members);
	}

	public void AddMember(Member member){
		members.add(member);
	}
	
	public ArrayList<Member> getUnPaidMembers(){
		ArrayList<Member> unpaidMembers = new ArrayList<Member>();
		for (int i = 0; i < this.members.size(); i++){
			if (this.members.get(i).getPaid() == false){
				unpaidMembers.add(this.members.get(i));
				//ChargePenalty(i);
			}
		}
		return unpaidMembers;
	}
	
	public void ChargePenalty (int index){
		double newBalance;
		int penaltyFee = 10;
		newBalance = this.members.get(index).getBalance() + penaltyFee;
		this.members.get(index).setBalance(newBalance);
	}
	
	public ArrayList<Member> getPaidMembers(){
		ArrayList<Member> paidMembers = new ArrayList<Member>();
		for (int i = 0; i < this.members.size(); i++){
			if (this.members.get(i).getPaid() == true){
				paidMembers.add(this.members.get(i));
				//ApplyDiscount(i);
			}
		}
		return paidMembers;
	}
	
	public void ApplyDiscount (int index){
		double newBalance;
		double oldBalance = this.members.get(index).getBalance();
		double discount = oldBalance * 0.10;
		newBalance = oldBalance - discount;
		this.members.get(index).setBalance(newBalance);
	}
	
	public void AddOriginalMembers(ArrayList<Member> members2) {
		members.add(new Member("Arshad Mohamed", "416-911-1911", "21 Jump Street", true, true, 60.0));
		members.add(new Member("Jonathan Bajada", "123-456-7890", "22 Jump Street", true, false, 60.0));
		members.add(new Member("Talhah Wahab", "098-765-4321", "23 Jump Street", false, false, 60.0));
		members.add(new Member("Faisal Basrah", "416-416-4416", "24 Jump Street", false, true, 60.0));
		members.add(new Member("Rohan Ali", "647-647-6647", "25 Jump Street", true, true, 60.0));
	}
	
	public int getSize(){
		return members.size();
	}
	
	public Member getMemberat(int index){
		return members.get(index);
	}
	
}
