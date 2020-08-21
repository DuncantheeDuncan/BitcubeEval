package assessmentproject.section5.friends;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface SendFriendRequest {

    Map<String, List<String>> requestFriendship(String accountOwner, List<String> receivers);

    static <K, V> Map<String, List<String>> clonePool(Map<String, List<String>> original) {

        Map<String, List<String>> copy = new HashMap<>();

        for (Map.Entry<String, List<String>> entry : original.entrySet()) {
            copy.put(entry.getKey(), entry.getValue());
        }

        return copy;
    }
}
