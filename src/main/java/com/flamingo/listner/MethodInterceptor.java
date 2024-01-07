//package com.flamingo.listner;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.testng.IMethodInstance;
//import org.testng.IMethodInterceptor;
//import org.testng.ITestContext;
//
//import com.flamingo.contsants.FrameworkConstants;
//import com.flamingo.utility.XlUtilities;
//
//public class MethodInterceptor implements IMethodInterceptor {
//
//	// list will contain all the testcases which gone execute
//
//	@Override
//	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
//
//		List<IMethodInstance> result = new ArrayList<>();
//
//		XlUtilities xlUtilities = new XlUtilities(FrameworkPathConstant.getExceltestrunner());
//		Map<String, String> map = null;
//		List<Map<String, String>> list = new ArrayList<>();
//		try {
//			int rowCount = xlUtilities.getRowCount("RUNMANAGER");
//			int colCount = xlUtilities.getCellCount("RUNMANAGER", 0);
//			for (int row = 1; row <= rowCount; row++) {
//				for (int col = 0; col < colCount; col++) {
//					map = new HashMap<>();
//					String key = xlUtilities.getCellData("RUNMANAGER", 0, col);
//					String value = xlUtilities.getCellData("RUNMANAGER", row, col);
//					map.put(key, value);
//				}
//				list.add(map);
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//		for (int row = 1; row < methods.size(); row++) {
//			for (int col = 0; col < list.size(); col++) {
//				if (methods.get(row).getMethod().getMethodName().equalsIgnoreCase(list.get(col).get("testName"))) {
//					if (list.get(col).get("execute").equalsIgnoreCase("yes")) {
//						methods.get(row).getMethod().setDescription(list.get(row).get("testDescription"));
//						methods.get(row).getMethod().setInvocationCount(Integer.parseInt(list.get(row).get("count")));
//						methods.get(row).getMethod()
//								.setInvocationCount(Integer.parseInt(list.get(row).get("priority")));
//						methods.get(row).getMethod().getGroups();
//						result.add(methods.get(row));
//					}
//				}
//			}
//			list.add(map);
//		}
//		return result;
//	}
//
//}
