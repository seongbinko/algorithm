package programmers;
/*
문제 설명
        스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다. 노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.



        속한 노래가 많이 재생된 장르를 먼저 수록합니다.
        장르 내에서 많이 재생된 노래를 먼저 수록합니다.
        장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
        노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때, 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.

        제한사항
        genres[i]는 고유번호가 i인 노래의 장르입니다.
        plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
        genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
        장르 종류는 100개 미만입니다.
        ** 장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
        모든 장르는 재생된 횟수가 다릅니다.
        입출력 예
        genres	plays	return
        [classic, pop, classic, classic, pop]	[500, 600, 150, 800, 2500]	[4, 1, 3, 0]
        입출력 예 설명
        classic 장르는 1,450회 재생되었으며, classic 노래는 다음과 같습니다.

        고유 번호 3: 800회 재생
        고유 번호 0: 500회 재생
        고유 번호 2: 150회 재생
        pop 장르는 3,100회 재생되었으며, pop 노래는 다음과 같습니다.

        고유 번호 4: 2,500회 재생
        고유 번호 1: 600회 재생
        따라서 pop 장르의 [4, 1]번 노래를 먼저, classic 장르의 [3, 0]번 노래를 그다음에 수록합니다.
*/
import java.util.*;
import java.util.stream.*;


public class Programmers20 {
    
    // Test 2 , 15 실패 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록고려하지 않음
    public static int[] solution1(String[] genres, int[] plays) {
        Map<String, List<Integer>> map = new HashMap<>();
        for(int i=0; i<genres.length; i++) {
            if(map.containsKey(genres[i])) {
                List<Integer> list =  map.get(genres[i]);
                list.add(plays[i]);
                map.put(genres[i], list);
            } else {

                List<Integer> list = new ArrayList<>();
                list.add(plays[i]);
                map.put(genres[i], list);
            }
        }

        Map<Integer,String> sumMap = new HashMap<>();
        List<Integer> sumList = new ArrayList();

        for(Map.Entry<String,List<Integer>> entry : map.entrySet()) {
            sumMap.put(entry.getValue()
                    .stream()
                    .mapToInt(i-> i).sum(), entry.getKey());
            sumList.add(entry.getValue()
                    .stream()
                    .mapToInt(i-> i).sum());
        }
        String strPlays[] = Arrays.stream(plays)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);
        if(sumList.size() > 1) sumList.sort(Collections.reverseOrder());

        ArrayList<Integer> result = new ArrayList<>();

        for(int x : sumList) {
            // 장르중에서 많이 재생된 순서
            String key = sumMap.get(x);
            // 특정 장르의 플레이된 횟수 내림차순으로 정리
            List<Integer> tempList =  map.get(key);

            if(tempList.size() > 1) {
                tempList.sort(Collections.reverseOrder());
                int rank1 = Arrays.asList(strPlays).indexOf(String.valueOf(tempList.get(0)));
                result.add(rank1);
                int rank2 =  Arrays.asList(strPlays).indexOf(String.valueOf(tempList.get(1)));
                result.add(rank2);
            } else {
                int rank1 = Arrays.asList(strPlays).indexOf(String.valueOf(tempList.get(0)));
                result.add(rank1);
            }
        }
        int[] answer = result.stream().mapToInt(i->i).toArray();
        return answer;

    }
    // 인덱스를 추가하였으나 효율성이 더떨어졌다 ...
    public static int[] solution2(String[] genres, int[] plays) {
        Map<String, List<Integer>> map = new HashMap<>();
        for(int i=0; i<genres.length; i++) {
            if(map.containsKey(genres[i])) {
                List<Integer> list =  map.get(genres[i]);
                list.remove(i);
                list.add(i,plays[i]);
                map.put(genres[i], list);
            } else {
                Integer[] temp = new Integer[plays.length];
                Arrays.fill(temp,0);
                List<Integer> list = new LinkedList<>(Arrays.asList(temp));
                list.remove(i);
                list.add(i,plays[i]);
                map.put(genres[i], list);
            }
        }

        Map<Integer,String> sumMap = new HashMap<>();
        List<Integer> sumList = new ArrayList();

        for(Map.Entry<String,List<Integer>> entry : map.entrySet()) {
            sumMap.put(entry.getValue()
                    .stream()
                    .mapToInt(i-> i).sum(), entry.getKey());
            sumList.add(entry.getValue()
                    .stream()
                    .mapToInt(i-> i).sum());
        }


        if(sumList.size() > 1) sumList.sort(Collections.reverseOrder());

        ArrayList<Integer> result = new ArrayList<>();

        for(int x : sumList) {

            List<Integer> tempList = map.get(sumMap.get(x));
            List<String> tempListToString =  tempList.stream().map(String::valueOf).collect(Collectors.toList());

            Collections.sort(tempList,Collections.reverseOrder());

            if(tempList.size() > 1) {
                int rank1 = tempListToString.indexOf(String.valueOf(tempList.get(0)));
                result.add(rank1);
                int rank2 =  tempListToString.indexOf(String.valueOf(tempList.get(1)));
                result.add(rank2);
            } else {
                int rank1 = tempListToString.indexOf(String.valueOf(tempList.get(0)));
                result.add(rank1);
            }
        }
        return result.stream().mapToInt(i->i).toArray();
    }

    public static int[] solution3(String[] genres, int[] plays) {
        // 장르 관련 맵, 노래관련 맵 2가지 필요
        HashMap<String,Integer> genreMap = new HashMap();
        HashMap<String,Integer> playMap = new HashMap();

        for(int i=0; i<genres.length; i++) {
            genreMap.put(genres[i], genreMap.getOrDefault(genres[i],0) + plays[i]);
            playMap.put(genres[i] + "_" + i, plays[i]);
        }
        // 가장 많이 들은 곡이 무엇인지 구분하고 내림차순 정렬
        genreMap = genreMap.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue , (o1,o2) -> o1, LinkedHashMap::new));

        LinkedList<Integer> list = new LinkedList<>();
        // for문 돌면서 높은 합의 장르부터 뽑고 그 장르를 바탕으로 노래의 key 값을 가져온다.분류한다.
        for(String genre : genreMap.keySet()) {
            String[] keys = playMap.entrySet()
                    .stream()
                    .filter(a -> a.getKey().contains(genre))
                    .sorted( (a,b) -> {
                                // 들은 횟수 value 값이 동일하면 키값으로 구분해서 분류한다
                                return a.getValue().equals(b.getValue()) ? a.getKey().compareTo(b.getKey()) : b.getValue().compareTo(a.getValue());
                            }
                    )
                    .limit(2)
                    .map(a -> a.getKey())
                    .collect(Collectors.joining(","))
                    .split(",");
            // _로 구분하여 들어간 키를 스플릿해서 index 값만 list에 담는다
            for(int i=0; i<keys.length; i++) {
                String[] s = keys[i].split("_");
                list.add(Integer.parseInt(s[1]));
            }
        }
        // 값을 answer 에 담는다
        int[] answer = new int[list.size()];
        for(int i = 0; i< answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;

    }



    public static void main(String[] args) {

        String[] input1 = {"classic", "pop", "classic", "classic", "pop"};
        int[] input2 =    {500, 600, 150, 800, 2500};
        int[] result = solution3(input1, input2);

        System.out.print(Arrays.toString(result) + " ");

    }
}
