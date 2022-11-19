/*
 * �ç���ҧ������ : ��Ѻ�Ҩ���
 * http://www.cp.eng.chula.ac.th/~somchai/books
 */
package datastr;

/**
 * �Թ�����ʷ������º�ԡ�âͧ�����硪ѹ
 * @author ����� ����Է���ٵ�С��
 */
public interface Collection {
  public void add(Object element);
  public void remove(Object element);
  public boolean isEmpty();
  public boolean contains(Object element);
  public int size();
}
