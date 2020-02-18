
public class StudentList extends CDLinkedList {
    // you can write additional methods.



	// implement this method
	public void removeStudent(String id) throws Exception {
		Student s;
		DListIterator i = new DListIterator (this.header.nextNode);
		while(i.hasNext() && i.currentNode.data != null) {
			s = (Student) i.currentNode.data;
			if(s.getId() == id) {
				this.removeAt(i);
			}
			i.next();
		}
	}

	// implement this method
	public void appendQuick(CDLinkedList list2) throws Exception {
		if(list2.size == 0) return;
		DListIterator iOgHead = new DListIterator (this.header);
		DListIterator iOgTail = new DListIterator (this.header.previousNode);
		DListIterator iApHead = new DListIterator (list2.header.nextNode);
		DListIterator iApTail = new DListIterator (list2.header.previousNode);
		iApTail.currentNode.nextNode = iOgHead.currentNode;
		iOgHead.currentNode.previousNode = iApTail.currentNode;
		iOgTail.currentNode.nextNode = iApHead.currentNode;
		iApHead.currentNode.previousNode = iOgTail.currentNode; 
	}

	// implement this method
	public void append(CDLinkedList list2) throws Exception {
		if(list2.size == 0) return;
		DListIterator i = new DListIterator (list2.header.nextNode);
		DListIterator iOgTail = new DListIterator (this.header.previousNode);
		while(i.hasNext() && i.currentNode.data != null) {
			Student appstud = (Student) i.currentNode.data;
			this.insert(appstud.createCopy(), iOgTail);
			i.next();
			iOgTail.next();
		}

	}

	// implement this method
	public CDLinkedList gender(int i) throws Exception {
		if(i != 1 && i !=0) return null;
		DListIterator itr = new DListIterator (this.header.nextNode);
		CDLinkedList newlst = new CDLinkedList();
		DListIterator newitr = new DListIterator(newlst.header);
		if(i == 0) {
			while(itr.hasNext() && itr.currentNode.data != null) {
				Student currstd = (Student) itr.currentNode.data;
				if(currstd.getSex() == "male") {
					newlst.insert(currstd.createCopy(), newitr);
					newitr.next();
				}
				itr.next();
			}
		}else if(i == 1) {	
			while(itr.hasNext() && itr.currentNode.data != null) {
				Student currstd = (Student) itr.currentNode.data;
				if(currstd.getSex() == "female") {
					newlst.insert(currstd.createCopy(), newitr);
					newitr.next();
				}
				itr.next();
			}
		}
		return newlst;
	}

}
