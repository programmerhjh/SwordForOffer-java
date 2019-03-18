package prv.offer.dealstring;

/**
 * 字符流中第一个不重复的字符
 * 
 * 题目描述
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 输出描述:
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 * 
 * 用字符数组记录每次加入字符对应ascii码下标加一记录重复次数
 * 寻找则按照字符串顺序查找数组中第一个值为1的字符
 * 
 * @author HJH
 *
 * @date 2019年3月18日
 */
public class FirstAppearingOnce {
	int[] ht = new int['z'+1];
    StringBuffer s = new StringBuffer();
    public void Insert(char c)
    {
        s.append(c);
        if(ht[c]==0)
            ht[c]=1;
        else ht[c]+=1;
    }
    public char firstAppearingOnce()
    {
        char[] str=s.toString().toCharArray();
        for(char c:str)
        {
            if(ht[c]==1)
                return c;
        }
        return '#';
    }
}
