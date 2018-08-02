class OPNCalculator {
	static int res1 = 0, res2 = 0;
	static int op1 = 0, op2 = 0;
	static int num = 0;
	static boolean op1Empty = true, op2Empty = true;
	static boolean res1Empty = true, res2Empty = true;

	public static void main(String args[]) {
		System.out.print(calcOPN(args[0]));
		// System.out.print(calcOPN("5 2 + 1 + 2 /"));
	}

	private static void forHelp() {
		System.out.println((int)'0'+" "+(int)'9');
	}

	private static void zeroizeOperandes() {
		op1 = 0;
		op2 = 0;
		op1Empty = true;
		op2Empty = true;
	}

	private static void zeroizeFirstOperand() {
		op1 = 0;
		op1Empty = true;
	}

	private static int assignValue(int op1, int op2, char symb) {
		int res = 0;
		if (symb == '+') {
			res = op1 + op2;
			return res;
		} else if (symb == '-') {
			res = op1 - op2;
			return res;
		} else if (symb == '*') {
			res = op1 * op2;
			return res;
		} else if (symb == '/') {
			res = op1 / op2;
			return res;
		}
		return res;
	}

	public static int calcOPN(String OPNstr) {
		for (int i = 0; i < OPNstr.length(); i++) {
			if ((int)OPNstr.charAt(i) >= 48 && (int)OPNstr.charAt(i) <= 57) {
				num = num * 10 + (int)OPNstr.charAt(i) - (int)'0';
			} else if (OPNstr.charAt(i) == ' ') {
				if (op1Empty && num != 0) {
					op1 = num;
					op1Empty = false;
				} else if (op2Empty && num != 0) {
					op2 = num;
					op2Empty = false;
				}
				num = 0;
			} else if (OPNstr.charAt(i) == '+' || OPNstr.charAt(i) == '*' || OPNstr.charAt(i) == '-' || OPNstr.charAt(i) == '/') {
				if (res1Empty) {
					res1 = assignValue(op1, op2, OPNstr.charAt(i));
					res1Empty = false;
					zeroizeOperandes();
				} else if (!op1Empty && op2Empty) {
					res1 = assignValue(res1, op1, OPNstr.charAt(i));
					zeroizeFirstOperand();
				} else if (res2Empty) {
					res2 = assignValue(op1, op2, OPNstr.charAt(i));
					res2Empty = false;
					zeroizeOperandes();
				} else {
					res1 = assignValue(res1, res2, OPNstr.charAt(i));
				}
			}
		}
		return res1;
	}
}