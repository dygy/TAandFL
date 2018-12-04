package prac5;

import java.util.Collections;
import java.util.List;

public class Calc {
    public static void calc(List<String> list,List<Integer> toRemove,List<Integer> atFirst) {
        if (list.get(0).equals("-")) {
            int result = Integer.parseInt(list.get(1)) * -1;

            for (int z = 0; z < atFirst.size(); z++) {
                if (list.get(atFirst.get(z)).equals("*")) {
                    list.set(atFirst.get(z) + 1, String.valueOf(
                            Integer.parseInt(
                                    list.get(atFirst.get(z) - 1)) *
                                    Integer.parseInt(list.get(atFirst.get(z) + 1
                                            )
                                    )
                            )
                    );

                    toRemove.add(atFirst.get(z));
                    toRemove.add(atFirst.get(z) - 1);

                }
                if (list.get(atFirst.get(z)).equals("/")) {

                    list.set(atFirst.get(z) + 1, String.valueOf(
                            Integer.parseInt(list.get(atFirst.get(z) - 1)
                            )
                                    /
                                    Integer.parseInt(list.get(atFirst.get(z) + 1
                                            )
                                    )
                            )
                    );

                    toRemove.add(atFirst.get(z));
                    toRemove.add(atFirst.get(z) - 1);

                }
            }

            Collections.sort(toRemove);
            Collections.reverse(toRemove);

            for (int removeIndex = 0; removeIndex < toRemove.size(); removeIndex++) {
                int remove = toRemove.get(removeIndex);

                list.remove(remove);


            }
            for (int y = 2; y < list.size(); y++) {

                if (list.get(y).equals("+")) {

                    result = result + Integer.parseInt(list.get(y + 1));
                }
                if (list.get(y).equals("-")) {

                    result = result - Integer.parseInt(list.get(y + 1));
                }

            }
            System.out.println(result);
        } else {

            int result = Integer.parseInt(list.get(0));
            for (int z = 0; z < atFirst.size(); z++) {
                if (list.get(atFirst.get(z)).equals("*")) {

                    list.set(atFirst.get(z) + 1, String.valueOf(
                            Integer.parseInt(
                                    list.get(atFirst.get(z) - 1)) *
                                    Integer.parseInt(list.get(atFirst.get(z) + 1
                                            )
                                    )
                            )
                    );

                    toRemove.add(atFirst.get(z));
                    toRemove.add(atFirst.get(z) - 1);

                }
                if (list.get(atFirst.get(z)).equals("/")) {


                    list.set(atFirst.get(z) + 1, String.valueOf(
                            Integer.parseInt(list.get(atFirst.get(z) - 1)
                            )
                                    /
                                    Integer.parseInt(list.get(atFirst.get(z) + 1
                                            )
                                    )
                            )
                    );

                    toRemove.add(atFirst.get(z));
                    toRemove.add(atFirst.get(z) - 1);

                }
            }

            Collections.sort(toRemove);
            Collections.reverse(toRemove);

            for (int removeIndex = 0; removeIndex < toRemove.size(); removeIndex++) {
                int remove = toRemove.get(removeIndex);

                list.remove(remove);


            }
            for (int y = 1; y < list.size(); y++) {

                if (list.get(y).equals("+")) {

                    result = result + Integer.parseInt(list.get(y + 1));
                }
                if (list.get(y).equals("-")) {
                    result = result - Integer.parseInt(list.get(y + 1));
                }
            }

            System.out.println(result);

        }

    }
}
