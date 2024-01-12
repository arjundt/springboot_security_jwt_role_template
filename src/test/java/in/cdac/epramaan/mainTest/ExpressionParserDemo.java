package in.cdac.epramaan.mainTest;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class ExpressionParserDemo {
	public static void main(String[] args) {
		ExpressionParser parser = new SpelExpressionParser();
		String role = parser.parseExpression("T(in.cdac.epramaan.user.model.Roles).ADMIN").getValue(String.class);
		System.out.println(role);
	}
}
