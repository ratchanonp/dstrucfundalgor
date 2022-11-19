/*
 * �ç���ҧ������ : ��Ѻ�Ҩ���
 * http://www.cp.eng.chula.ac.th/~somchai/books
 */
package datastr;

/**
 * �Թ�����ʷ������º�ԡ�âͧ��¡��
 * @author ����� ����Է���ٵ�С��
 */
public interface List extends Collection {
  public void add(int index, Object e);
  public void remove(int index);
  public Object get(int index);
  public void set(int index, Object e);
  public int indexOf(Object e);
}
