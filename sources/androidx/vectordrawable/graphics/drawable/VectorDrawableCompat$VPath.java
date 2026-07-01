package androidx.vectordrawable.graphics.drawable;

import android.content.res.Resources$Theme;
import android.graphics.Path;
import android.util.Log;
import androidx.core.graphics.PathParser;
import androidx.core.graphics.PathParser$PathDataNode;
import b.d.b.a.a;

/* JADX INFO: loaded from: classes.dex */
public abstract class VectorDrawableCompat$VPath extends VectorDrawableCompat$VObject {
    public static final int FILL_TYPE_WINDING = 0;
    public int mChangingConfigurations;
    public int mFillRule;
    public PathParser$PathDataNode[] mNodes;
    public String mPathName;

    public VectorDrawableCompat$VPath() {
        super(null);
        this.mNodes = null;
        this.mFillRule = 0;
    }

    public void applyTheme(Resources$Theme resources$Theme) {
    }

    public boolean canApplyTheme() {
        return false;
    }

    public PathParser$PathDataNode[] getPathData() {
        return this.mNodes;
    }

    public String getPathName() {
        return this.mPathName;
    }

    public boolean isClipPath() {
        return false;
    }

    public String nodesToString(PathParser$PathDataNode[] pathParser$PathDataNodeArr) {
        String string = " ";
        for (int i = 0; i < pathParser$PathDataNodeArr.length; i++) {
            StringBuilder sbU = a.U(string);
            sbU.append(pathParser$PathDataNodeArr[i].mType);
            sbU.append(":");
            string = sbU.toString();
            for (float f : pathParser$PathDataNodeArr[i].mParams) {
                StringBuilder sbU2 = a.U(string);
                sbU2.append(f);
                sbU2.append(",");
                string = sbU2.toString();
            }
        }
        return string;
    }

    public void printVPath(int i) {
        String strW = "";
        for (int i2 = 0; i2 < i; i2++) {
            strW = a.w(strW, "    ");
        }
        StringBuilder sbX = a.X(strW, "current path is :");
        sbX.append(this.mPathName);
        sbX.append(" pathData is ");
        sbX.append(nodesToString(this.mNodes));
        Log.v(VectorDrawableCompat.LOGTAG, sbX.toString());
    }

    public void setPathData(PathParser$PathDataNode[] pathParser$PathDataNodeArr) {
        if (PathParser.canMorph(this.mNodes, pathParser$PathDataNodeArr)) {
            PathParser.updateNodes(this.mNodes, pathParser$PathDataNodeArr);
        } else {
            this.mNodes = PathParser.deepCopyNodes(pathParser$PathDataNodeArr);
        }
    }

    public void toPath(Path path) {
        path.reset();
        PathParser$PathDataNode[] pathParser$PathDataNodeArr = this.mNodes;
        if (pathParser$PathDataNodeArr != null) {
            PathParser$PathDataNode.nodesToPath(pathParser$PathDataNodeArr, path);
        }
    }

    public VectorDrawableCompat$VPath(VectorDrawableCompat$VPath vectorDrawableCompat$VPath) {
        super(null);
        this.mNodes = null;
        this.mFillRule = 0;
        this.mPathName = vectorDrawableCompat$VPath.mPathName;
        this.mChangingConfigurations = vectorDrawableCompat$VPath.mChangingConfigurations;
        this.mNodes = PathParser.deepCopyNodes(vectorDrawableCompat$VPath.mNodes);
    }
}
