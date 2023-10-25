package com.example.a65

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.Nullable

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /**
        문자열 s가 입력되었을 때 다음 규칙을 따라서
        이 문자열을 여러 문자열로 분해하려고 합니다.

        먼저 첫 글자를 읽습니다. 이 글자를 x라고 합시다.
        이제 이 문자열을 왼쪽에서 오른쪽으로 읽어나가면서,
        ##x와 x가 아닌 다른 글자들이 나온 횟수를 각각 셉니다.##
        처음으로 두 횟수가 같아지는 순간 멈추고,
        지금까지 읽은 문자열을 분리합니다.
        s에서 분리한 문자열을 빼고 남은 부분에 대해서 이 과정을 반복합니다.
        남은 부분이 없다면 종료합니다.
        만약 두 횟수가 다른 상태에서 더 이상 읽을 글자가 없다면,
        역시 지금까지 읽은 문자열을 분리하고, 종료합니다.
        문자열 s가 매개변수로 주어질 때,
        위 과정과 같이 문자열들로 분해하고,
        분해한 문자열의 개수를 return 하는 함수 solution을 완성하세요.
        **/
        /**입출력 예 #1
        s="banana"인 경우
        ba - na - na와 같이 분해됩니다.
        x= s[0] = b
        s[0]=b .... x랑 같으므로 count :trueCount ++
        s[1]=a .... x랑 다르므로 count :falseCount ++
        이때 최초로 값이 같아지므로 문자열을 분리!
        x= s[2] = n
        s[2]=n
        s[3]=a
        이때 최초로 값이 같아지므로 문자열을 분리!

        입출력 예 #2
        s="abracadabra"인 경우
        ab - ra - ca - da - br - a와 같이 분해됩니다.

        입출력 예 #3
        s="aaabbacc/ccab/ba"인 경우
        aaabbacc - ccab - ba와 같이 분해됩니다.
        **/
        class Solution {
            fun solution(s: String): Int {
                var answer: Int = 0

                var res = mutableListOf<String>()
                //최초 문자 비교값
                var x : Char = s[0]
                var count_x :Int = 0
                var count_nx :Int = 0
                var i: Int = 0
                //비교하기
                for(index in i..s.length-1){
                    //값 비교
                    if(s[index]==x) count_x++
                    else count_nx++
                    //마지막 문자열에서 비교할 문자가없다면 그 기존의 것들 문자열분리!
                    //카운트값이 같다면 분리
                    if(count_x==count_nx){
                        //문자 추가
                        res.add(s.substring(i..index))
                        //값들 초기화
                        count_x=0
                        count_nx=0
                        i=index+1
                        if(i==s.length) break
                        x=s[i]
                    }
                    else if(index==s.length-1){
                        res.add(s.substring(i..index))
                    }
                }
                answer = res.size

                return answer
            }
        }
        val a = Solution()
        a.solution("banana")
        a.solution("abracadabra")
        a.solution("aaabbaccccabba")
    }
}