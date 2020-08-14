package com.earth2me.essentials;

import me.totalfreedom.totalfreedommod.TotalFreedomMod;
import me.totalfreedom.totalfreedommod.admin.AdminList;
import me.totalfreedom.totalfreedommod.util.FLog;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class TFMHandler
{
    private Essentials plugin;
    private TotalFreedomMod tfmPlugin;

    public TFMHandler()
    {
        this.plugin = Essentials.getPlugin(Essentials.class);
        this.tfmPlugin = null;
    }

    public TotalFreedomMod getTFM()
    {
        if (tfmPlugin == null)
        {
            try
            {
                final Plugin tfm = plugin.getServer().getPluginManager().getPlugin("TotalFreedomMod");
                if (tfm != null && tfm instanceof TotalFreedomMod)
                {
                    tfmPlugin = (TotalFreedomMod)tfm;
                }
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
        return tfmPlugin;
    }

    public boolean isAdmin(User user)
    {
        return getTFM().al.isAdmin(user.getBase());
    }

    public boolean isAdmin(CommandSender sender)
    {
        return getTFM().al.isAdmin(sender);
    }

    public boolean isAdmin(Player player)
    {
        return getTFM().al.isAdmin(player);
    }

    public boolean isVanished(User user)
    {
        return isVanished(user.getBase());
    }

    public boolean isVanished(Player player)
    {
        if (tfmPlugin != null)
        {
            getTFM();
        }
        return AdminList.vanished.contains(player.getName());
    }

    public void warning(String warning)
    {
        if (tfmPlugin != null)
        {
            getTFM();
        }
        FLog.warning(warning);
    }

    public void info(String info)
    {
        if (tfmPlugin != null)
        {
            getTFM();
        }
        FLog.info(info);
    }
    /*
    private static Logger logger;
    private static Function<Player, Boolean> adminProvider;
    private static Function<Player, Boolean> vanishProvider;
    public static void setLogger(Logger logger)
    {
        TFMHandler.logger = logger;
    }
    public static Plugin getTFM()
    {
        final Plugin tfm = Bukkit.getPluginManager().getPlugin("TotalFreedomMod");
        if (tfm == null)
        {
            logger.warning("Could not resolve plugin: TotalFreedomMod");
        }
        return tfm;
    }
    public boolean isAdmin(User user)
    {
        return isAdmin(user.getBase());
    }
    @SuppressWarnings({"unchecked", "ConstantConditions"})
    public boolean isAdmin(Player player)
    {
        if (adminProvider == null)
        {
            final Plugin tfm = getTFM();
            if (tfm == null)
            {
                return false;
            }
            Object provider = null;
            for (RegisteredServiceProvider<?> serv : Bukkit.getServicesManager().getRegistrations(tfm))
            {
                if (Function.class.isAssignableFrom(serv.getService()))
                {
                    provider = serv.getProvider();
                }
            }
            if (provider == null)
            {
                warning("Could not obtain admin service provider!");
                return false;
            }
            adminProvider = (Function<Player, Boolean>) provider;
        }
        return adminProvider.apply(player);
    }
    public boolean isVanished(User user)
    {
        return isVanished(user.getBase());
    }
    @SuppressWarnings({"unchecked", "ConstantConditions"})
    public boolean isVanished(Player player)
    {
        if (vanishProvider == null)
        {
            final Plugin tfm = getTFM();
            if (tfm == null)
            {
                return false;
            }
            Object provider = null;
            for (RegisteredServiceProvider<?> serv : Bukkit.getServicesManager().getRegistrations(tfm))
            {
                if (Function.class.isAssignableFrom(serv.getService()))
                {
                    provider = serv.getProvider();
                }
            }
            if (provider == null)
            {
                warning("Could not obtain vanish service provider!");
                return false;
            }
            vanishProvider = (Function<Player, Boolean>) provider;
        }
        return vanishProvider.apply(player);
    }
    public static void warning(String warning)
    {
        logger.warning(warning);
    }
    public static void info(String info)
    {
        logger.info(info);
    }
    */
}