package androidx.print;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.CancellationSignal;
import android.print.PrintAttributes;
import android.print.PrintAttributes$MediaSize;
import android.print.PrintDocumentAdapter$LayoutResultCallback;
import android.print.PrintDocumentInfo$Builder;
import java.io.FileNotFoundException;

/* JADX INFO: loaded from: classes.dex */
public class PrintHelper$PrintUriAdapter$1 extends AsyncTask<Uri, Boolean, Bitmap> {
    public final /* synthetic */ PrintHelper$PrintUriAdapter this$1;
    public final /* synthetic */ CancellationSignal val$cancellationSignal;
    public final /* synthetic */ PrintDocumentAdapter$LayoutResultCallback val$layoutResultCallback;
    public final /* synthetic */ PrintAttributes val$newPrintAttributes;
    public final /* synthetic */ PrintAttributes val$oldPrintAttributes;

    public PrintHelper$PrintUriAdapter$1(PrintHelper$PrintUriAdapter printHelper$PrintUriAdapter, CancellationSignal cancellationSignal, PrintAttributes printAttributes, PrintAttributes printAttributes2, PrintDocumentAdapter$LayoutResultCallback printDocumentAdapter$LayoutResultCallback) {
        this.this$1 = printHelper$PrintUriAdapter;
        this.val$cancellationSignal = cancellationSignal;
        this.val$newPrintAttributes = printAttributes;
        this.val$oldPrintAttributes = printAttributes2;
        this.val$layoutResultCallback = printDocumentAdapter$LayoutResultCallback;
    }

    @Override // android.os.AsyncTask
    public /* bridge */ /* synthetic */ Bitmap doInBackground(Uri[] uriArr) {
        return doInBackground2(uriArr);
    }

    @Override // android.os.AsyncTask
    public /* bridge */ /* synthetic */ void onCancelled(Bitmap bitmap) {
        onCancelled2(bitmap);
    }

    @Override // android.os.AsyncTask
    public /* bridge */ /* synthetic */ void onPostExecute(Bitmap bitmap) {
        onPostExecute2(bitmap);
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
        this.val$cancellationSignal.setOnCancelListener(new PrintHelper$PrintUriAdapter$1$1(this));
    }

    /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
    public Bitmap doInBackground2(Uri... uriArr) {
        try {
            PrintHelper$PrintUriAdapter printHelper$PrintUriAdapter = this.this$1;
            return printHelper$PrintUriAdapter.this$0.loadConstrainedBitmap(printHelper$PrintUriAdapter.mImageFile);
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: onCancelled, reason: avoid collision after fix types in other method */
    public void onCancelled2(Bitmap bitmap) {
        this.val$layoutResultCallback.onLayoutCancelled();
        this.this$1.mLoadBitmap = null;
    }

    /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
    public void onPostExecute2(Bitmap bitmap) {
        PrintAttributes$MediaSize mediaSize;
        super.onPostExecute(bitmap);
        if (bitmap != null && (!PrintHelper.PRINT_ACTIVITY_RESPECTS_ORIENTATION || this.this$1.this$0.mOrientation == 0)) {
            synchronized (this) {
                mediaSize = this.this$1.mAttributes.getMediaSize();
            }
            if (mediaSize != null && mediaSize.isPortrait() != PrintHelper.isPortrait(bitmap)) {
                Matrix matrix = new Matrix();
                matrix.postRotate(90.0f);
                bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            }
        }
        this.this$1.mBitmap = bitmap;
        if (bitmap != null) {
            this.val$layoutResultCallback.onLayoutFinished(new PrintDocumentInfo$Builder(this.this$1.mJobName).setContentType(1).setPageCount(1).build(), true ^ this.val$newPrintAttributes.equals(this.val$oldPrintAttributes));
        } else {
            this.val$layoutResultCallback.onLayoutFailed(null);
        }
        this.this$1.mLoadBitmap = null;
    }
}
