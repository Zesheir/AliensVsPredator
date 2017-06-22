package org.avp.client.render.items.firearms.parts;

import org.avp.client.model.items.Model88MOD4;
import org.avp.client.render.items.ItemRendererGroup;
import org.lwjgl.opengl.GL11;

import com.arisux.mdx.lib.client.Model;
import com.arisux.mdx.lib.client.TexturedModel;
import com.arisux.mdx.lib.client.render.OpenGL;
import com.arisux.mdx.lib.game.Game;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public class RenderItem88Mod4Action extends ItemRendererGroup<Model88MOD4>
{
    public RenderItem88Mod4Action(TexturedModel<Model88MOD4> model, ModelRenderer... modelRenderers)
    {
        super(model, modelRenderers);
    }

    @Override
    public void renderInInventory(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.pushMatrix();
        {
            float glScale = 32F * Model.DEFAULT_SCALE;
            OpenGL.scale(glScale, -glScale, glScale);
            OpenGL.rotate(45F, -1F, 1F, 0F);
            OpenGL.translate(-0.01F, -0.15F, -0.16F);
            this.renderPart();
        }
        OpenGL.popMatrix();
    }
    
    @Override
    public void renderInWorld(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.pushMatrix();
        {
            OpenGL.rotate((this.mc.world.getWorldTime() + Game.partialTicks() % 360) * 10, 0.0F, 1.0F, 0.0F);
            OpenGL.disable(GL11.GL_CULL_FACE);
            this.renderPart();
        }
        OpenGL.popMatrix();
    }
}