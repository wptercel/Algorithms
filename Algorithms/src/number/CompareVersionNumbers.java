/*
 * Compare two version numbers version1 and version2.
If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 13.37
 */
package number;

import java.util.StringTokenizer;

public class CompareVersionNumbers {
	public int compareVersion(String version1, String version2) {
        StringTokenizer st1 = new StringTokenizer(version1, ".", false);
        StringTokenizer st2 = new StringTokenizer(version2, ".", false);
        while(st1.hasMoreTokens() || st2.hasMoreTokens()){
            int cp1 = st1.hasMoreTokens() ? Integer.parseInt(st1.nextToken()) : 0;
            int cp2 = st2.hasMoreTokens() ? Integer.parseInt(st2.nextToken()) : 0;
            if(cp1 > cp2)
                return 1;
            else if(cp1 < cp2)
                return -1;
            else
                continue;
        }
        return 0;
    }
}
