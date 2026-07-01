package androidx.appcompat.view;

import android.view.Menu;
import android.view.MenuItem;

/* JADX INFO: loaded from: classes.dex */
public interface ActionMode$Callback {
    boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem);

    boolean onCreateActionMode(ActionMode actionMode, Menu menu);

    void onDestroyActionMode(ActionMode actionMode);

    boolean onPrepareActionMode(ActionMode actionMode, Menu menu);
}
