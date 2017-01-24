package com.epam.allandnow.basic;

import com.sun.jndi.url.corbaname.corbanameURLContextFactory;

public class OperandsPriorityTest {

	String stringField;

	/**
	 * @return the stringField
	 */
	String getStringField() {
		return stringField;
	}

	/**
	 * @param stringField
	 *            the stringField to set
	 */
	void setStringField(String stringField) {
		this.stringField = stringField;
	}

	public static void main(String[] args) {
		OperandsPriorityTest operandsPriorityTest1 = new OperandsPriorityTest();
		//operandsPriorityTest1.setStringField("s");
		OperandsPriorityTest operandsPriorityTest2 = new OperandsPriorityTest();
		operandsPriorityTest1.equals(operandsPriorityTest2);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((stringField == null) ? 0 : stringField.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		OperandsPriorityTest other = (OperandsPriorityTest) obj;
		if (
				(
						(stringField == null) &
						(other.stringField != null)
			    )
				|| (stringField == null ) & !stringField.equals(other.stringField)) {
			System.out.println("false");
			return false;
		}
		return true;
	}

  @Override
  public String toString() {
    return "OperandsPriorityTest [stringField=" + stringField + "]";
  }
	
	

}
