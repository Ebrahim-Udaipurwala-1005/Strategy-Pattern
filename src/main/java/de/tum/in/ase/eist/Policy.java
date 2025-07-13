package de.tum.in.ase.eist;

public class Policy {
    private Context context;

    public Policy(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void configure() {
        if (!(context.isChaptersSortedByName() || context.isChaptersSortedByPageNumber())) {
            context.setSearchAlgorithm(new LinearSearch());
        }
        else if (context.isChaptersSortedByName()) {
            context.setSearchAlgorithm(new BinarySearch());
        }
        else if (context.isChaptersSortedByPageNumber()) {
            context.setSearchAlgorithm(new InterpolationSearch());
        }
    }
}
