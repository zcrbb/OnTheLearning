package impl

import "golang.org/x/text/cases"

/*

227. 基本计算器 II
给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。

整数除法仅保留整数部分。

示例 1：

输入：s = "3+2*2"
输出：7
示例 2：

输入：s = " 3/2 "
输出：1
示例 3：

输入：s = " 3+5 / 2 "
输出：5


提示：

1 <= s.length <= 3 * 105
s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开
s 表示一个 有效表达式
表达式中的所有整数都是非负整数，且在范围 [0, 231 - 1] 内
题目数据保证答案是一个 32-bit 整数

-------------------------------------------------------------------

这题在第一次看到的时候是一点思路都没有, 第一次遇到这样的题, 我选择看答案.

感觉有点意思.

因为这题没有括号了. 计算的先后顺序仅取决于符号.

"*", "/" 是需要先与身边的元素进行运算的.

"+" 是直接运算, "-"是取相反数之后运算.

主要还是放栈里这一步不好想, 高运算级的符号需要和栈顶元素进行运算 .

*/

func calculate2(s string) int {
	num := 0
	preSign := '+'
    stack := []byte{}
	for i := 0; i < len(s); i++ {
		if isDigital(s[i]) {
			num += num*10 + int(s[i]-'0')
		}
		if s[i] != ' ' && !isDigital(s[i]) {
			switch preSign {
			case '+':
                stack = append(stack, s[i])

            case '-':
                stack = append(stack, -s[i])
			}

            case '*':
                
		}
	}
	return 0
}

func isDigital(b byte) bool {
	return '0' <= b && b <= '9'
}
