//package assessmentproject.section5.friends;
//
//import assessmentproject.web.WebProcessor;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class ReturnUserFriends {
//
//    public Map<String, List<String>> returnFriends(String myEmailId) {
//
//        Map<String, List<String>> mappingFriends = new HashMap<>();
//        List<String> mappingList = new ArrayList<>();
//        Map<String, List<String>> getOnlyMyFriends = new HashMap<>();
//
//
//        if (!WebProcessor.friends.get(myEmailId).isEmpty()) {
//
//            for (Map.Entry<String, List<String>> x : WebProcessor.friends.entrySet()) {
//
//                if (x.getKey().equals(myEmailId)) {
//
//                    getOnlyMyFriends.put(x.getKey(), x.getValue());
//
//                    for (String xx : x.getValue()) {
//
//                        if (!mappingList.contains(x.getKey()))
//                            mappingList.add(x.getKey());
//
//
//                        mappingFriends.put(xx, mappingList);
//
//                    }
//
//                }
//
//            }
//        }
//
//
//        WebProcessor.friends.putAll(mappingFriends);
//
//        System.out.println("my friends only " + getOnlyMyFriends);
//        System.out.println("mapped friends " + mappingFriends);
//        System.out.println("friends after " + WebProcessor.friends);
//
//        return getOnlyMyFriends;
//    }
//
//}
