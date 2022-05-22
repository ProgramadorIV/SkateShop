window.onload = function(){

    const app = new PIXI.Application({
        width: window.innerWidth , 
        height: window.innerHeight, 
        backgroundColor: 0, 
        backgroundAlpha: 0,
        resolution: window.devicePixelRatio || 1,
    });
    document.body.appendChild(app.view);
    
    
    /*ESTAS SON LAS LETRAS BIEN WAPAS */
    
    
    const estilo = new PIXI.TextStyle({
    
        fontFamily: 'urban',
        dropShadow: true,
        dropShadowAlpha: 0.8,
        dropShadowAngle: 2.1,
        dropShadowBlur: 4,
        dropShadowColor: '0x111111',
        dropShadowDistance: 10,
        fill: ['#ffffff'],
        stroke: '#004620',
        fontSize: 100,
        fontWeight: 'lighter',
        lineJoin: 'round',
        strokeThickness: 12,
    });
    
    const estiloError = new PIXI.TextStyle({
    
        fontFamily: 'urban',
        dropShadow: true,
        dropShadowAlpha: 0.8,
        dropShadowAngle: 2.1,
        dropShadowBlur: 4,
        dropShadowColor: '0x111111',
        dropShadowDistance: 10,
        fill: ['#ffffff'],
        stroke: '#004620',
        fontSize: 40,
        fontWeight: 'lighter',
        lineJoin: 'round',
        strokeThickness: 12,
        letterSpacing: 4,
    });
    
    
    const textoError = new PIXI.Text('ERROR', estilo);
    const textoDe = new PIXI.Text('DEDICADO A', estilo);
    const textoLuismi = new PIXI.Text('LUISMI', estilo);
    const textoDelError = new PIXI.Text('NO SE PUEDE ENTRAR EN OPCIONES DE ADMINISTRADOR COMO USUARIO', estiloError);
    
    textoError.skew.set(0.65, -0.3);
    textoError.anchor.set(0.5, 0.5);
    textoError.x = 300;
    textoError.y = 200; 
    
    textoLuismi.skew.set(-0.65, 0.32);
    textoLuismi.anchor.set(0.5,0.5);
    textoLuismi.x = 1600;
    textoLuismi.y = 208;
    
    textoDe.anchor.set(0.5,0.5);
    textoDe.x = app.screen.width / 2;
    textoDe.y = 150;
    
    textoDelError.anchor.set(0.5,0.5);
    textoDelError.x = app.screen.width / 2;
    textoDelError.y = 800;
    
    app.stage.addChild(textoError);
    app.stage.addChild(textoLuismi);
    app.stage.addChild(textoDe);
    app.stage.addChild(textoDelError);
    
    
    
    /*ESTA ES LA ANIMACIÓN*/
    
    const container = new PIXI.Container();
    
    app.stage.addChild(container);
    
    // Create a new texture
    const texture = PIXI.Texture.from('./media/luismi.jpg');
    let separacion = 80;
    let escala = 1;
    let tam = 5;
    let tiempo = 0;
    // Create a 5x5 grid of bunnies
    for (let i = 0; i < tam*tam; i++) {
    
        const bunny = new PIXI.Sprite(texture);
        bunny.scale.set(escala);
        bunny.anchor.set(0.5);
        bunny.x = (i % tam) * separacion;
        bunny.y = Math.floor(i / tam) * separacion;
        container.addChild(bunny);
        app.ticker.add((delta) => {
            
            bunny.rotation += 0.01 * delta;
    
           /* if(i==(Math.floor( tam*tam/2))){
                bunny.scale.set(escala*(0.5*(1*Math.sin(2*Math.PI*tiempo/200))));
            }*/
            
        });
    }
    
    // Move container to the center
    container.x = app.screen.width / 2;
    container.y = app.screen.height / 2;
    
    // Center bunny sprite in local container coordinates
    container.pivot.x = container.width / 2;
    container.pivot.y = container.height / 2;
    //container.scale.set(0.5);
    // Listen for animate update
    app.ticker.add((delta) => {
        // rotate the container!
        // use delta to create frame-independent transform
        tiempo+=delta;
        container.rotation -= 0.01 * delta;
    });
}



