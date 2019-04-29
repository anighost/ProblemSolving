package problems.algo.treesgraphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
 * 	Given a list of employee id and manager id pairs, and given a manager id print/return the manager hierarchy, 
	starting at that manager. For example, given (employee_id,manager_id) as [(1,3), (2,3), (3,4)] and manager_id 4, 
	return {4:[3], 3:[1,2]}. How would you handle the opposite direction, i.e. 
	given an employee_id print the hierarchy of managers.
 */
public class EmployeeManager {
	
	class ListNode {
		int emp;
		ListNode mgr;
		ListNode(int x) { emp = x; }
		@Override
		public String toString() {
			return "ListNode [emp=" + emp + ", mgr=" + mgr + "]";
		}
		
	}

	// 4 - (3)
	// 3 - (1,2)

	Map<Integer, List<Integer>> result = new TreeMap<Integer, List<Integer>>();

	public Map<Integer, List<Integer>> getEmployees(int[][] employees, int managerId) {
		Map<Integer, List<Integer>> mgrMap = createManagerMap(employees);
		traverseManager(mgrMap, managerId);
		return result;
	}

	public ListNode getManagers(int[][] employees, int empId) {
		Map<Integer, Integer> empMap = createEmpMap(employees);
		return traverseEmployee(empMap, empId);
	}

	private void traverseManager(Map<Integer, List<Integer>> mgrMap, int managerId) {
		if (mgrMap.get(managerId) != null) {
			//get employees as vals and add to res
			List<Integer> empList = result.get(managerId);
			if(empList == null) {
				empList = new ArrayList<Integer>();
			}

			empList.addAll(mgrMap.get(managerId));
			result.put(managerId, empList);
			//recursion
			for (int empId : mgrMap.get(managerId)) {
				traverseManager(mgrMap, empId);
			}
		}
	}

	private Map<Integer, List<Integer>> createManagerMap(int[][] employees) {
		Map<Integer, List<Integer>> mgrMap = new HashMap<Integer, List<Integer>>();
		for (int i = 0; i < employees.length; i++) {
			int [] emps = employees[i];
			int emp = emps[0];
			int mgr = emps[1];

			List<Integer> empList = mgrMap.get(mgr);
			if(empList == null) {
				empList = new ArrayList<Integer>();
			}
			empList.add(emp);
			mgrMap.put(mgr, empList);
		}

		return mgrMap;
	}

	private ListNode traverseEmployee(Map<Integer, Integer> empMap, int empId) {
		ListNode curr = new ListNode(empId);
		Integer mgrId = empMap.get(empId); 
		if (mgrId != null) {
			curr.mgr = traverseEmployee(empMap, mgrId);
		}
		
		return curr;
	}

	
	private Map<Integer, Integer> createEmpMap(int[][] employees) {
		Map<Integer, Integer> empMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < employees.length; i++) {
			int [] emps = employees[i];
			int emp = emps[0];
			int mgr = emps[1];
			empMap.put(emp, mgr);
		}

		return empMap;
	}
	public static void main(String[] args) {
		
		int [][] emps = new int [][] {{1,3}, {2,3}, {3,4},{5,4}};
		EmployeeManager e = new EmployeeManager();
		
		Map<Integer, List<Integer>> mgrMap = e.getEmployees(emps, 4);
		System.out.println(mgrMap.toString());
		System.out.println(e.getManagers(emps, 1));
	}

}
