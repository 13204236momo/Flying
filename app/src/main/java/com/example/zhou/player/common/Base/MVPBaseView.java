package com.example.zhou.player.common.Base;

/**
 * Created by zhou on 2017/8/12.
 */

public interface MVPBaseView<P extends MVPBasePresenter>  {
    void setPresenter(P presenter);

    void permissionRefuse(String... reason);
}
