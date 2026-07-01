package androidx.preference;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.ContextMenu$ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem$OnMenuItemClickListener;
import android.view.View;
import android.view.View$OnCreateContextMenuListener;
import android.widget.Toast;

/* JADX INFO: loaded from: classes.dex */
public class Preference$OnPreferenceCopyListener implements View$OnCreateContextMenuListener, MenuItem$OnMenuItemClickListener {
    private final Preference mPreference;

    public Preference$OnPreferenceCopyListener(Preference preference) {
        this.mPreference = preference;
    }

    @Override // android.view.View$OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu$ContextMenuInfo contextMenu$ContextMenuInfo) {
        CharSequence summary = this.mPreference.getSummary();
        if (!this.mPreference.isCopyingEnabled() || TextUtils.isEmpty(summary)) {
            return;
        }
        contextMenu.setHeaderTitle(summary);
        contextMenu.add(0, 0, 0, R$string.copy).setOnMenuItemClickListener(this);
    }

    @Override // android.view.MenuItem$OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        ClipboardManager clipboardManager = (ClipboardManager) this.mPreference.getContext().getSystemService("clipboard");
        CharSequence summary = this.mPreference.getSummary();
        clipboardManager.setPrimaryClip(ClipData.newPlainText("Preference", summary));
        Toast.makeText(this.mPreference.getContext(), this.mPreference.getContext().getString(R$string.preference_copied, summary), 0).show();
        return true;
    }
}
