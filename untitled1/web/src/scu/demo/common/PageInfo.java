package scu.demo.common;

import java.util.ArrayList;
import java.util.List;

public class PageInfo<T> {
    /**
     * 当前所在页数
     */
    private int pageNo;
    /**
     * 每一页的记录数
     */
    private int pageSize;
    /**
     * 当前所在页的记录列表
     */
    private List<T> list;
    /**
     * 页面总数
     */
    private int totalPage;
    /**
     * 记录总数
     */
    private int totalRecord;
    /**
     * 要展示的页面数字
     */
    private List<Integer> showNos;
    private int prev;
    private int next;
    private int showFirst;
    private int showLast;
    private boolean hasPrev;
    private boolean hasNext;

    public PageInfo() {
        showNos = new ArrayList<>();
    }

    public PageInfo(int pageNo, int pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        showNos = new ArrayList<>();
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public List<Integer> getShowNos() {
        return showNos;
    }

    public void setShowNos(List<Integer> showNos) {
        this.showNos = showNos;
    }

    public int getPrev() {
        return prev;
    }

    public void setPrev(int prev) {
        this.prev = prev;
    }

    public int getNext() {
        return next;
    }

    public void setNext(int next) {
        this.next = next;
    }

    public int getShowFirst() {
        return showFirst;
    }

    public void setShowFirst(int showFirst) {
        this.showFirst = showFirst;
    }

    public int getShowLast() {
        return showLast;
    }

    public void setShowLast(int showLast) {
        this.showLast = showLast;
    }

    public boolean isHasPrev() {
        return hasPrev;
    }

    public void setHasPrev(boolean hasPrev) {
        this.hasPrev = hasPrev;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    /**
     * 会根据当前的<code>pageSize</code>自动设置<code>totalPage</code>
     * @param totalRecord
     */
    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
        this.totalPage = (totalRecord % pageSize == 0) ? (totalRecord /pageSize) : (totalRecord /pageSize) + 1;

        //设置要展示的页码数
        showNos.clear();
        int start, end;
        if(totalPage < 10){
            start = 1;
            end = totalPage;
        }
        else{
            start = pageNo - 4;
            end = pageNo + 5;
            if(start < 1) {
                start = 1;
                end = start + 9;
            }
            if(end > totalPage){
                end = totalPage;
                start = end - 9;
            }
        }
        for(int i = start;i <= end;i++)
            showNos.add(i);
        showFirst = showNos.get(0);
        showLast = showNos.get(showNos.size() - 1);
        hasPrev = (pageNo != 1);
        hasNext = (pageNo != totalPage);
        prev = hasPrev ? pageNo - 1:pageNo;
        next = hasNext ? pageNo + 1:pageNo;

    }
}
