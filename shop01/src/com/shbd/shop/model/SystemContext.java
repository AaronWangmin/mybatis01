package com.shbd.shop.model;

public class SystemContext {
	private static ThreadLocal<Integer> pageIndex = new ThreadLocal<Integer>();
	private static ThreadLocal<Integer> pageSize = new ThreadLocal<Integer>();
	private static ThreadLocal<Integer> pageOffset = new ThreadLocal<Integer>();
	private static ThreadLocal<String> order = new ThreadLocal<String>();// 升序？降序
	private static ThreadLocal<String> sort = new ThreadLocal<String>(); // 根据哪个字段进行排序

	public static void setPageIndex(int _pageIndex) {
		pageIndex.set(_pageIndex);
	}

	public static int getPageIndex() {
		return pageIndex.get();
	}

	public static void removerPageIndex() {
		pageIndex.remove();
	}

	public static void setPageSize(int _pageSize) {
		pageSize.set(_pageSize);
	}

	public static int getPageSize() {
		return pageSize.get();
	}

	public static void removerPageSize() {
		pageSize.remove();
	}

	public static void setPageOffset(int _pageOffset) {
		pageOffset.set(_pageOffset);
	}

	public static int getPageOffset() {
		return pageOffset.get();
	}

	public static void removerPageOffset() {
		pageOffset.remove();
	}

	public static void setOrdert(String _order) {
		order.set(_order);
	}

	public static String getOrder() {
		return order.get();
	}

	public static void removerOrder() {
		order.remove();
	}

	public static void setSort(String _sort) {
		sort.set(_sort);
	}

	public static String getSort() {
		return sort.get();
	}

	public static void removerSort() {
		sort.remove();
	}

}
