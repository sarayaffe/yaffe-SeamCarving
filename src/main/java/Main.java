public class Main {
    /*
    classes:
        imageio.read - to read image stream
                getRGB(int x, int y) - use this method to get individual method, returns an int
        bufferedimage
        color class - can pass rgb value as int


    Calculating energy of each pixel:
        for each pixel, look at pixel to right left below and above current one
        comparison of above/below and left/right will give value for pic in middle
        (above.getRed() - below.getRed())^2 + (a.getGreen() - b.getGreen())^2 ....+blue^2
        same for right and left. add everything together

        border should be highest possible value - 6*255^2

        test energy with 3x3 array of ints[][] or colors[][] (maybe switch first dimension to be y and 2nd to be x
        make sure that 3x3 array of pixels->correct 3x3 array of energy
        energy is based off colors of neighbors, not off energy of neighbors

        energy photo based on max and min energies. calculate bright = ((energy-min)/(max-min))*255
        brightness = new color(bright, bright, bright)
        dont include borders when calculating max. borders can just be white


        - energy calculator and energy test classes

     */
}
